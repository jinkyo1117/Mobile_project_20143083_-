# Mobile_project_20143083_-

모바일프로젝트
HW1
20143083 윤진교

XML파일 경로 : app - src - main - res - layout

java파일 경로 : app - src - main - com - example - mobile_project_1

AVD : Nexus 5X API 29

SDK Platforms : Android 10.0

1. 로그인 화면(RelativeLayout)
-상단에 TextView로 앱 이름 ‘JinKyo’s APP’ 출력합니다.
- EditText로 ID와 패스워드를 입력 받습니다. 로그인 버튼을 누르면, ID 입력 값은 스트링으로 변환한 뒤 getFilesDir를 사용해 기존에 저장되어 있는 파일에 접근하고, 입력 받은 ID와 같은 파일이름이 존재하면 파일을 열고, 존재하지 않으면 ‘비밀번호가 맞지 않습니다’라는 Toast를 띄워 로그인을 막습니다. 
파일을 여는데 성공했다면, 파일 내용 첫 줄에 있는 비밀번호와 EditText의 패스워드 입력 값을 스트링으로 변환한 다음 값을 비교합니다. 비교하여 같다면 ‘로그인 성공’ Toast를 띄운 뒤 startActivity(intent)를 이용해 계산기 화면으로 이동합니다.
- 회원가입 버튼을 누르면, ‘회원가입 화면으로 이동합니다.’ Toast를 띄운 뒤 startActivity(intent)를 이용해 회원가입 화면으로 이동합니다.
- 종료 버튼을 누르면, ‘종료합니다’ Toast를 띄운 뒤 finish()를 사용해 애플리케이션을 종료합니다.

2. 회원가입 화면(LinearLayout)
- 상단에 TextView로 ‘회원가입 화면’ 출력합니다.
- 회원가입 버튼을 누르면, ID 패스워드 이름 전화번호 주소를 차례대로 EditText를 사용해 입력 받고 스트링으로 변환합니다.
기존에 있는 ID인지 확인하기 위하여 ID입력값으로 파일을 열고 여는데 성공했다면 ‘중복된 아이디입니다’ Toast를 띄우고 checkid 변수를 0으로 바꾼 뒤 회원가입을 중단합니다.
기존에 있는 아이디가 아니라면 checkid 변수를 1로 바꾼 뒤 회원가입을 진행합니다.
- 패스워드 입력 값에 특수문자가 있는지 확인합니다. checkPW 변수에 특수문자가 있으면 false 없으면 true 반환합니다.
- 라디오 버튼으로 구현한 개인정보 동의 여부를 입력 받아 동의버튼을 클릭하면 0으로 초기화 되어있는 checkRadio 변수를 1로 설정, 클릭하지 않으면 0으로 설정합니다.
- checkRadio 변수가 0이라면 ‘개인정보 동의를 하셔야 합니다’ Toast를 띄운 뒤 회원가입을 중단합니다.
checkPW 변수가 false라면 ‘비밀번호에 특수문자는 사용 할 수 없습니다’ Toast 띄운 뒤 회원가입을 중단합니다.
비밀번호 입력 값이 없다면 ‘비밀번호를 입력해 주세요.’ Toast 띄운 뒤 회원가입을 중단합니다.
checkid 변수가 1이고 위의 if문에 해당이 되지 않으면 패스워드, 이름, 전화번호, 주소를 아이디 명의 txt 파일로 저장하고 ‘회원가입 성공!’ Toast 띄운 뒤 finish()를 사용해 종료합니다.
- 종료 버튼을 누르면 ‘회원가입 종료’ Toast를 띄운 뒤 finish()를 사용해 종료합니다.

3. 계산기 화면(TabelLayout)
- 상단에 TextView로 ‘계산기 화면’ 출력합니다.
- ImageView로 계산기 이미지 출력합니다.
- EditText로 첫번째 숫자와 두번째 숫자 입력 받습니다.
- RadioGroup을 생성해 RadioButton 4개를 묶습니다.
4개의 사칙연산 버튼을 누르면 각각 함수가 실행됩니다. 첫번째와 두번째 숫자를 입력 받은 값을 사칙연산을 실행하여 setText로 TextVIew에 결과값을 출력합니다.
- 종료버튼을 누르면 ‘계산기를 종료합니다.’ Toast를 띄운 뒤 finish()를 사용해 종료합니다.

