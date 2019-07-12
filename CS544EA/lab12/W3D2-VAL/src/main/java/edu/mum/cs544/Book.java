package edu.mum.cs544;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.SafeHtml;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "名称只能输入是中文字符")
    @SafeHtml(message = "名称只能输入是中文字符")
    private String title;
    @ISBN(message = "名称只能输入是中文字符")
    private String ISBN;
    @NotBlank(message = "名称只能输入是中文字符")
    @SafeHtml(message = "名称只能输入是中文字符")
    private String author;
    @Positive
    private double price;
}
