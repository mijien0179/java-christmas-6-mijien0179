Input
---
- 12월 방문 날짜
  - require
    - 숫자만
    - 1-31까지
  - exception
    - 숫자인가?
    - 날짜 범위를 벗어났는가?
- 주문
  - require
    - "$menu1-$count1,$menu2-$count2" 형식
    - 1차 separator ','
    - 2차 separator '-'
  - exception
    - 지정된 형식을 벗어났는가? 형식은 require 참조
    - 중복 메뉴 있는지
    - 메뉴 최대수 `20`넘는가?
    - 음료만 있는가?
    - menu
      - 등록된 메뉴이름인지?
    - count
      - 숫자인가?
      - 자연수인가?

View
---
- hello world
- 날짜 입력
- 메뉴 주문 안내
- 혜택 미리보기 안내
  - 주문 목록 출력
  - 할인 전 총 주문액 출력
  - 조건에 따른 증정 메뉴
  - 조건에 따른 혜택 내역
  - 조건에 따른 총 혜택 금액
  - 할인 후 총 결제 금액
  - 12월 이벤트 배지
- error
  - require
    - `[ERROR]` 메시지로 시작

Controller
---
- 할인 계산기
  - require
    - 총 주문 `1만원 이상?`
  - 총 주문액에서 할인
    - require
      - CURRENT_DAY <= CHRISTMAS 
    - (24 - CHRISTMAS - CURRENT_DAY) * 100 + 1000 
  - 평일 디저트 할인
    - require
      - 평일
      - 디저트
    - n * 2023
  - 주말 메인 메뉴 할인
    - require
      - 주말
      - 메인 디쉬
    - n * 2023
  - 특수 할인
    - require
      - 일요일
      - 크리스마스
    - 총 주문액 -1000
- 증정 이벤트
  - 할인 전 금액 12만원 ↑
  - 샴페인
- 혜택금액에 따른 뱃지
  - 5천원 `별`
  - 1만원 `트리`
  - 2만원 `산타`