with recursive time as ( #time이라고 하는 임시테이블 생성
    select 0 as hour #초기값을 설정, 컬럼명을 hour로 설정 
    union all select hour+1 #for문처럼 조건을 줄 행의 값의 연산 삽입 
    from time where hour < 23 #조건을 끝내줄 용도의 코드 삽입 
)

select time.hour, count(animal_id) 
from time left join animal_outs ao on time.hour = hour(ao.datetime) #time table과 animal_outs table 조인
group by time.hour; #time대 별로 그룹함수

