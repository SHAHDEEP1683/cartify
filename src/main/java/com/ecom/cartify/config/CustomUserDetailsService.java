package com.ecom.cartify.config;

import com.ecom.cartify.entity.Admin;
import com.ecom.cartify.entity.Customer;
import com.ecom.cartify.entity.Seller;
import com.ecom.cartify.repositry.AdminRepositry;
import com.ecom.cartify.repositry.CustomerRepositry;
import com.ecom.cartify.repositry.SellerRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepositry customerRepository;
    private final SellerRepositry sellerRepository;
    private final AdminRepositry adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Search Customer
        Optional<Customer> customerOpt = customerRepository.findByEmail(email);
        if (customerOpt.isPresent()) {
            Customer c = customerOpt.get();
            return new CustomUserDetails(c.getEmail(), c.getPassword(), c.getRole());
        }

        // Search Seller
        Optional<Seller> sellerOpt = sellerRepository.findByEmail(email);
        if (sellerOpt.isPresent()) {
            Seller s = sellerOpt.get();
            return new CustomUserDetails(s.getEmail(), s.getPassword(), s.getRole());
        }

        // Search Admin
        Optional<Admin> adminOpt = adminRepository.findByEmail(email);
        if (adminOpt.isPresent()) {
            Admin a = adminOpt.get();
            return new CustomUserDetails(a.getEmail(), a.getPassword(), a.getRole());
        }

        throw new UsernameNotFoundException("User not found");
    }
}
