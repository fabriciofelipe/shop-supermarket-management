package com.shop.supermarket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

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

}
