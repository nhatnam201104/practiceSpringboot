package com.example.backend.domain.dto;

import com.example.backend.common.constant.AppConstants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor
public class PageRequestDto {

    @Min(value = 0, message = "page must be >= 0")
    private int page = AppConstants.DEFAULT_PAGE;

    @Min(value = 1, message = "size must be >= 1")
    @Max(value = AppConstants.MAX_SIZE, message = "size must be <= 100")
    private int size = AppConstants.DEFAULT_SIZE;

    private String sortBy = AppConstants.DEFAULT_SORT_BY;

    private String sortDirection = AppConstants.DEFAULT_SORT_DIRECTION;

    public Pageable toPageable() {
        Sort.Direction direction = AppConstants.SORT_DIRECTION_DESC.equalsIgnoreCase(sortDirection)
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, sortBy == null || sortBy.isBlank()
                ? AppConstants.DEFAULT_SORT_BY
                : sortBy);
        return PageRequest.of(page, size, sort);
    }
}
