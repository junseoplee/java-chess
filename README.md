# java-chess
## 1단계 - 체스판 초기화
### 기능 요구 사항
- **체스판 생성**
- [x] 체스판의 세로는 아래부터 위로 1 ~ 8로 구현한다
- [x] 체스판의 가로는 왼쪽부터 a ~ h로 구현한다
- **체스 말 배치**
- [x] 체스 말의 흑, 백은 대문자와 소문자로 구분한다
- [x] 체스 말의 종류는 폰, 룩, 나이트, 비숍, 퀸, 킹이 있다
- [x] 체스 말은 위치를 갖는다 (각자 초기 위치를 갖고있다)
  - 8: RNBQKBNR 배치
  - 7: PPPPPPPP 배치
  - 6~3: ........ 으로 배치
  - 2: pppppppp 배치
  - 1: rnbqkbnr 배치
- **입력**
- [x] 게임 시작 명령어는 start, 종료는 end 입력이 올바르지 않다면 예외 처리한다 

## 2단계 - 말 이동
### 기능 요구 사항
- **체스 말**
- [ ] 이동 가능한지 검사
  - [ ] 체스 판의 범위를 벗어나면 이동할 수 없다
  - [ ] 이동 위치에 같은 색의 체스 말이 있다면 이동할 수 없다
  - [ ] 이동 위치에 다른 색의 체스 말이 있다면 이동할 수 있다
  - [ ] 체스 말 마다 가능한 이동이 다르다
    - [x] 이동 위치를 입력 받아 가능한 이동인지 계산하고 판단한다
- [ ] 경로를 반환한다
- **체스판**
- [ ] 체스 말을 움직인다
- [ ] 체스 말들의 위치를 갖고 있다
  - [ ] 선택한 위치에 체스 말이 없다면 예외 처리한다
  - [ ] 체스 말을 이동할 순서가 다르다면 예외 처리한다
- [ ] 체스 말이 반환한 경로 안에 다른 체스 말이 있는지 검사
  - [ ] 경로 안에 다른 체스 말이 있다면 이동할 수 없다
- **입력**
- [ ] 이동은 색을 번갈아가며 한다
- [ ] move source위치 target위치을 실행해 이동한다
