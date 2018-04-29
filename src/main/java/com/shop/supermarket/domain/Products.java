package com.shop.supermarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "products")
public class Products {

    private String id;
    private String name;
    //frios,higiene pessoal, higiene do lar, bebibas, congelados, outros, frutas vegetais, nao pereciveis,temperos e molhos, padaria
    private String type;
    private Integer amount;
    private BigDecimal price;
    private String status = "active";
    private DateTime created;
    private DateTime lastModified;

}
