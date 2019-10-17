package edu.mum.cs.serveremployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.serveremployee.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
