package edu.mum.cs544;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer bookId;
    private String bookName;
    @ManyToOne
    @JoinTable(name = "book_publisher",
            joinColumns = {@JoinColumn(name = "publisher_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private Publisher publisher;

}
