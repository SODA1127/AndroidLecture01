# Activity | Fragment Assignment 평가 기준

## 학생 과제 제출 시 조건

### 	최소 요구사항

- Acitivty는 최소 2개 이상 생성 및 연결하기
- Activity간 Primitive Type의 데이터와 Reference Type데이터를 Intent에 담아서 보내보기
- 한 Activity의 경우 무조건 프래그먼트를 2개 이상 교체가 가능한 ViewGroup 구성하기
- 프래그먼트 간 데이터 전달을 위한 코드 구성하기(Fragment -> Activity -> Fragment)

### 	발전 된 방법으로 개발해보기

- 화면 회전 시 데이터를 보존할 수 있도록 LifeCycle에 맞게 데이터 백업 및 복원 코드
- ViewPager를 활용한 프래그먼트 활용
- Activity의 경우 ActivityForResult를 통해 결과 값을 받아 처리하는 앱 만들기
- 프래그먼트가 있는 화면에서 뒤로가기를 눌렀을 때 기존에 BackStack에 저장된 프래그먼트 불러오기

## 평가 기준

Activity

- Activity의 LifeCycle에 대해 명확히 이해하고 활용하는가
- Intent 사용 시 Extra 데이터를 넘길 때 올바른 방법으로 사용하였는가
- Android Manifest에 Activity 태그에 대해 명확히 이해하고 등록하였는가

Fragment

- Fragment의 LifeCycle에 대해 명확히 이해하고 활용하는가
- 프래그먼트의 데이터 전달을 하기 위해 Bundle을 잘 활용하였는가
- FragmentManager를 명확히 이해하고 Transaction 및 BackStack을 구성하였는가
