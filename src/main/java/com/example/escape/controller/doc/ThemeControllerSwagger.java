package com.example.escape.controller.doc;

import com.example.escape.dto.SearchCondition;
import com.example.escape.dto.ThemeDetailDto;
import com.example.escape.dto.ThemeListItemDto;
import com.example.escape.util.Type;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ThemeControllerSwagger {

    @Operation(method = "GET", summary = "테마 전체 조회"
            , description = "파라미터로 page, size 등을 입력할 수 있습니다. ex) /api/themes?page=3&size=10\n page는 0부터 시작입니다." +
            "\n정렬 시에는 파라미터로 sort를 입력할 수 있습니다. ex) /api/themes?sort=title,desc")
    @ApiResponse(responseCode = "200")
    @Parameter(name = "type", description = "조회 기준", example = "store")
    @Parameter(name = "store", description = "조회 기준이 store일 경우 매장 이름 입력", example = "키이스케이프")
    @Parameter(name = "pageable", hidden = true)
    @Parameter(name = "page", example = "0")
    @Parameter(name = "size", example = "1")
    @Parameter(name = "sort", example = "id,asc")
    Page<ThemeListItemDto> findAll(Type type, String store, Pageable pageable);

    @Operation(method = "GET", summary = "테마 검색", description = "파라미터로 page, size 등을 입력할 수 있습니다. ex) /api/themes?page=3&size=10\n page는 0부터 시작입니다." +
            "\n정렬 시에는 파라미터로 sort를 입력할 수 있습니다. ex) /api/themes?sort=title,desc")
    @ApiResponse(responseCode = "200")
    @Parameter(name = "type", description = "조회 기준", example = "title")
    @Parameter(name = "keyword", description = "검색 키워드 입력", example = "back")
    @Parameter(name = "difficult", description = "테마의 난이도", example = "3")
    @Parameter(name = "address", description = "매장의 위치 키워드", example = "")
    @Parameter(name = "condition", hidden = true)
    @Parameter(name = "pageable", hidden = true)
    @Parameter(name = "page", example = "0")
    @Parameter(name = "size", example = "1")
    @Parameter(name = "sort", example = "id,asc")
    Page<ThemeListItemDto> searchTheme(SearchCondition condition, Pageable pageable);

    @Operation(method = "GET", summary = "테마 단일 조회", description = "테마의 상세 정보 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "not found")})
    @Parameter(name = "themeId", description = "테마 id", example = "1", required = true)
    ThemeDetailDto findById(Long themeId);
}
