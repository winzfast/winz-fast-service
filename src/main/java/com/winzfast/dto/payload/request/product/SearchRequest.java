package com.winzfast.dto.payload.request.product;

import com.winzfast.model.Specification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ADMIN
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

    private String title;

}
