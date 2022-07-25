// package org.zerock.guestbook.dto;

// import java.util.List;
// import java.util.function.Function;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;

// import lombok.Data;

// @Data
// public class PageResultDTO<DTO, EN> {
//     private List<DTO> dtoList; // 페이지에 나열되는 목록

//     private int totalPage; // 총 페이지 수
//     private int page; // 현재 페이지
//     private int size; // 목록 사이즈
//     private int start, end; // 페이지 시작, 끝 번호
//     private boolean prev, next; // 이전, 다음
//     private List<Integer> pageList; // 페이지 번호 목록

//     // Page<EN> result은 복수개의 데이터가 담김
// public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
//     dtoList = result.stream().map(fn).collect(Collectors.toList());
//     totalPage = result.getTotalPages();
//     makePageList(result.getPageable());
// }

//     private void makePageList(Pageable pageable) {
//         page = pageable.getPageNumber() + 1; // 현재 페이지 번호
//         size = pageable.getPageSize(); // 페이지 갯수, 사이즈
//         int tempEnd = (int) (Math.ceil(page / 10.0)) * 10; // 계산되어 끝나는 페이지
//         start = tempEnd - 9; // 시작 페이지
//         prev = start > 1; // 이전페이지
//         end = totalPage > tempEnd ? tempEnd : totalPage; // 실제 끝 페이지
//         next = totalPage > tempEnd; // 다음 페이지
//         // 페이지네이션
//         pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

//     }
// }

package org.zerock.guestbook.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;
//목록에 쓸 수있는 필수 DTO

@Data
public class PageResultDTO<DTO, EN> {
    private List<DTO> dtoList;// 페이지에 나열되는 목록

    private int totalPage;// 총페이지수
    private int page; // 현재 페이지
    private int size; // 총 페이지 목록
    private boolean prev, next; // 이전, 다음버튼
    private List<Integer> pageList; // 페이지번호목록
    private int start;// 페이지 시작 번호
    private int end; // 페이지 끝 번호

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) { // result = 밖에
        // 선언된 변수, fn = EN, DTO로 받는 함수정의
        // dtoList = result.stream().map(fn).collect(Collectors.toList()); // result에
        // stream할겁니다 map(fn)한 것을> 그리고 그것을
        // collector로 변환하여 dtoList에 넣을겁니다 >> dtolist
        // 넘어오는 dto는 pageable로 n개씩 저장된 객체가 넘어옴

        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
        makePageList(result.getPageable());

    }

    private void makePageList(Pageable pageable) {
        page = pageable.getPageNumber() + 1; // 현재 페이지 번호
        size = pageable.getPageSize(); // 페이지 갯수, 사이즈
        int tempEnd = (int) (Math.ceil(page / 10.0)) * 10; // 계산되어 끝나는 페이지
        start = tempEnd - 9; // 시작 페이지
        prev = start > 1; // 이전페이지
        end = totalPage > tempEnd ? tempEnd : totalPage; // 실제 끝 페이지
        next = totalPage > tempEnd; // 다음 페이지
        // 페이지네이션
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

    }
}

// private void makePageList(Pageable pageable) {
// page = pageable.getPageNumber() + 1; // 현재 페이지번호
// size = pageable.getPageSize(); // 페이지 갯수,사이즈
// int tmpEnd = (int) (Math.ceil(page / 10.0) * 10); // 계산되어 끝나는 페이지
// start = tmpEnd - 9; // 시작페이지
// prev = start > 1; // 이전으로
// end = totalPage > tmpEnd ? tmpEnd : totalPage; // 실제 끝나는 페이지
// next = totalPage > tmpEnd; // 다음페이지
// pageList = IntStream.rangeClosed(start,
// end).boxed().collect(Collectors.toList());
// // ㄴ 페이지네이션(페이지를 IntStream으로 start부터 end까지 만듬)
// }
// }
