package com.gustavo.gestao_api_rest.services;

import com.gustavo.gestao_api_rest.dto.UsuarioDTO;
import com.gustavo.gestao_api_rest.entities.Role;
import com.gustavo.gestao_api_rest.entities.Usuario;
import com.gustavo.gestao_api_rest.projections.UsuarioDetailsProjection;
import com.gustavo.gestao_api_rest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UsuarioDetailsProjection> result = usuarioRepository.searchUserAndRolesByEmail(username);
        if (result.size() == 0) {
            throw new UsernameNotFoundException("Email não encontrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(username);
        usuario.setSenha(result.get(0).getSenha());
        for (UsuarioDetailsProjection projection : result) {
            usuario.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }
        return usuario;
    }

    protected Usuario authenticated() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");
            return usuarioRepository.findByEmail(username).get();
        }
        catch (Exception e) {
            throw new UsernameNotFoundException("Email não encontrado");
        }
    }

    @Transactional(readOnly = true)
    public UsuarioDTO getMe() {
        Usuario usuario = authenticated();
        return new UsuarioDTO(usuario);
    }
}
