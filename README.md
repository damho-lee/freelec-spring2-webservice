# freelec-spring2-webservice
### 오류내용
-PostApiControllerTest Posts_수정된다() 테스트 오류
update가 되지 않는 현상 발생
PostsService의 update함수에 @Transactional Annotation 빼먹음

![image](https://user-images.githubusercontent.com/121997029/235298294-4fc491f7-daa7-4d86-8ee7-e70bd4b5c81e.png)

변경 후
![image](https://user-images.githubusercontent.com/121997029/235298303-5b741b0b-20f4-4dee-b3aa-c310e16054b2.png)

## Mustache 문제
Controller에서 "userName" 사용시 윈도우 환경변수 문제로 인해 시스템 유저이름을 가져옴
-> userName 대신 다른 변수명 사용 (loginUserName)
