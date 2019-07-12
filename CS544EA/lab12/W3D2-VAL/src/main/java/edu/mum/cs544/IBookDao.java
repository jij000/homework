package edu.mum.cs544;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookDao extends JpaRepository<Book, Integer>  {

}
