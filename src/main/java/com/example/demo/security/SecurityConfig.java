// package com.example.demo.security;

// import com.example.demo.security.jwt.JwtAuthenticationFilter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableWebSecurity
// @SuppressWarnings("deprecation")
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     private final CustomUserDetailsService userDetailsService;
//     private final JwtAuthenticationFilter jwtFilter;

//     public SecurityConfig(CustomUserDetailsService userDetailsService,
//                           JwtAuthenticationFilter jwtFilter) {
//         this.userDetailsService = userDetailsService;
//         this.jwtFilter = jwtFilter;
//     }

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(userDetailsService)
//             .passwordEncoder(passwordEncoder());
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .authorizeRequests()
//             .antMatchers(
//                 "/api/auth/**",
//                 "/v2/api-docs",
//                 "/swagger-ui/**",
//                 "/swagger-resources/**"
//             ).permitAll()
//             .anyRequest().authenticated()
//             .and()
//             .sessionManagement()
//             .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//         http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return NoOpPasswordEncoder.getInstance(); // simple for project
//     }

//     @Bean
//     @Override
//     public AuthenticationManager authenticationManagerBean() throws Exception {
//         return super.authenticationManagerBean();
//     }
// }
