package webdemo.myshop.Dto.Response;

import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CategoryResponse {
    private int categoryId;
    private String categoryName;
}
