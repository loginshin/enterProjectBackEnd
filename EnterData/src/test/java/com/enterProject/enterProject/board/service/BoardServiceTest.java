//package com.enterProject.enterProject.board.service;
//
//import com.enterProject.enterProject.board.domain.BoardEntity;
//import com.enterProject.enterProject.board.dto.BoardCreateRequest;
//import com.enterProject.enterProject.board.dto.BoardDTO;
//import com.enterProject.enterProject.board.repository.BoardRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//
///**
// * BoardService 단위 테스트
// * 비즈니스 로직의 올바른 동작 여부를 검증하며, 외부 의존성(Repository)은 Mocking 처리합니다.
// */
//@ExtendWith(MockitoExtension.class)
//class BoardServiceTest {
//
//    @InjectMocks
//    private BoardService boardService;
//
//    @Mock
//    private BoardRepository boardRepository;
//
//    @Test
//    @DisplayName("게시글 생성 요청 시, Repository를 통해 저장하고 결과를 반환한다")
//    void create_success() {
//        // Given
//        BoardCreateRequest request = new BoardCreateRequest("새 글 제목", "새 글 내용", "user-uuid");
//        BoardEntity entity = BoardEntity.builder()
//                .boardKey("test-uuid-100")
//                .boardTitle(request.title())
//                .boardContents(request.contents())
//                .createUserKey(request.userKey())
//                .build();
//
//        given(boardRepository.save(any(BoardEntity.class))).willReturn(entity);
//
//        // When
//        BoardDTO result = boardService.create(request);
//
//        // Then
//        assertThat(result).isNotNull();
//        assertThat(result.boardKey()).isEqualTo("test-uuid-100");
//        assertThat(result.boardTitle()).isEqualTo("새 글 제목");
//        verify(boardRepository).save(any(BoardEntity.class));
//    }
//
//    @Test
//    @DisplayName("게시글 ID로 조회 시, 해당 정보를 반환한다")
//    void findById_success() {
//        // Given
//        String targetId = "test-uuid-1";
//        BoardEntity entity = BoardEntity.builder()
//                .boardKey(targetId)
//                .boardTitle("기존 게시글")
//                .build();
//
//        given(boardRepository.findById(targetId)).willReturn(Optional.of(entity));
//
//        // When
//        BoardDTO result = boardService.findById(targetId);
//
//        // Then
//        assertThat(result).isNotNull();
//        assertThat(result.boardKey()).isEqualTo(targetId);
//        assertThat(result.boardTitle()).isEqualTo("기존 게시글");
//    }
//}
