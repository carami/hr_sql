Oracle XE 18 설치

1.	압축 해제, setup.exe 실행
2.	라이선스 동의함. 다음버튼 클릭
3.	설치 경로 지정. C”\oracle\product\18.0.0 으로 변경하고 다음 버튼 클릭
4.	Sys, system, pdbadmin 암호를 지정한다. 1234로 입력한다.
5.	경로 확인 후 설치버튼을 클릭한다.
6.	방화벽 관련 설정 창이 열리면 허용한다.
7.	설치 완료

Create user c##carami identified by 1234 default tablespace users temporary tablespace temp;

grant resource, connect, create view to c##carami;

alter user c##carami default tablespace users quota unlimited on users;

사용자 삭제

drop user c##carami cascade;

https://github.com/oracle/db-sample-schemas/releases/tag/v18c
