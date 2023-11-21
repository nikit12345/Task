//package com.example.utills;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtUtils {	
//
//	public static final String SECRET = "5367566B59703373367639792F423F45284"   
//	
//	    public String generateToken(String subject) {
//	        return Jwts.builder()
//	                .setSubject(subject)
//	                .setIssuedAt(new Date(System.currentTimeMillis()))
//	                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
//	                .signWith(SignatureAlgorithm.HS256, secretKey)
//	                .compact();
//	    }
//
//	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//	        final Claims claims = extractAllClaims(token);
//	        return claimsResolver.apply(claims);
//	    }
//
//	    private Claims extractAllClaims(String token) {
//	        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//	    }
//
//	    public boolean isTokenExpired(String token) {
//	        return extractExpiration(token).before(new Date());
//	    }
//
//	    private Date extractExpiration(String token) {
//	        return extractClaim(token, Claims::getExpiration);
//	    }
//
//	    public String extractSubject(String token) {
//	        return extractClaim(token, Claims::getSubject);
//	    }
//
//	    public boolean validateToken(String token) {
//	        return !isTokenExpired(token);
//	    }
//	}
//
//
//}
