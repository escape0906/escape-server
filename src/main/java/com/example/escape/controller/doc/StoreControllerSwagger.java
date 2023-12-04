package com.example.escape.controller.doc;

import com.example.escape.dto.SearchCondition;
import com.example.escape.dto.StoreListItemDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreControllerSwagger {

    @Operation(method = "GET", summary = "매장 목록 전체 조회", description = "현재 데이터가 있는 매장 목록" +
            "\n파라미터로 page, size 등을 입력할 수 있습니다. ex) /api/stores?page=3&size=10\n page는 0부터 시작입니다." +
            "\n정렬 시에는 파라미터로 sort를 입력할 수 있습니다. ex) /api/stores?sort=title,desc")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "사용자 입력 오류")
    })
    @Parameter(name = "pageable", hidden = true)
    @Parameter(name = "page", example = "0")
    @Parameter(name = "size", example = "1")
    @Parameter(name = "sort", example = "id,asc")
    Page<StoreListItemDto> findAll(Pageable pageable);

    @Operation(method = "GET", summary = "매장 검색",
            description = "키워드로 매장을 검색" +
                    "\n파라미터로 page, size 등을 입력할 수 있습니다. ex) /api/stores?page=3&size=10\n page는 0부터 시작입니다." +
                    "\n정렬 시에는 파라미터로 sort를 입력할 수 있습니다. ex) /api/stores?sort=title,desc")
    @ApiResponse(responseCode = "200")
    @Parameter(name = "keyword", description = "검색 키워드 입력", example = "back")
    @Parameter(name = "address", description = "매장의 위치 키워드", example = "")
    @Parameter(name = "condition", hidden = true)
    @Parameter(name = "pageable", hidden = true)
    @Parameter(name = "page", example = "0")
    @Parameter(name = "size", example = "1")
    @Parameter(name = "sort", example = "id,asc")
    Page<StoreListItemDto> search(SearchCondition condition, Pageable pageable);

}
