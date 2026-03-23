//package com.enterProject.enterProject.board.controller;
//
//import com.enterProject.enterProject.board.dto.BoardCreateRequest;
//import com.enterProject.enterProject.board.dto.BoardDTO;
//import com.enterProject.enterProject.board.service.BoardService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * BoardRestController API 슬라이스 테스트
// * 웹 레이어만 로드하여 엔드포인트 매핑, JSON 응답 포맷 등을 집중적으로 검증합니다.
// */
//@WebMvcTest(BoardRestController.class)
//class BoardRestControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private BoardService boardService;
//
//    @Test
//    @DisplayName("게시글 생성 API: 올바른 요청 데이터가 들어오면 성공 응답을 반환한다")
//    void create_success() throws Exception {
//        // Given
//        BoardCreateRequest request = new BoardCreateRequest("테스트 제목", "테스트 내용", "user-uuid");
//        BoardDTO responseDto = new BoardDTO("test-uuid-1", "테스트 제목", "테스트 내용", "user-uuid", LocalDateTime.now(), "user-uuid", LocalDateTime.now());
//
//        given(boardService.create(any(BoardCreateRequest.class))).willReturn(responseDto);
//
//        // When & Then
//        mockMvc.perform(post("/api/boards")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value("0000"))
//                .andExpect(jsonPath("$.data.boardTitle").value("테스트 제목"))
//                .andExpect(jsonPath("$.data.createUserKey").value("user-uuid"));
//    }
//
//    @Test
//    @DisplayName("게시글 단건 조회 API: 존재하지 않는 ID로 요청하면 실패한다 (실패 시나리오 예시)")
//    void findById_fail_when_notFound() throws Exception {
//        // Given
//        String invalidId = "invalid-uuid";
//        given(boardService.findById(invalidId)).willThrow(new RuntimeException("게시글을 찾을 수 없습니다."));
//
//        // When & Then
//        mockMvc.perform(get("/api/boards/{id}", invalidId))
//                .andExpect(status().isInternalServerError()); // 전역 예외 처리기가 없을 경우 기본 500 응답
//    }
//}
