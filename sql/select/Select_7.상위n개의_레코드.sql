# LIMIT offset, size  ex) limit 0, 10
# Limit size : offset = 0 생략됨  ex) limit 10

select name
    from animal_ins
    order by datetime
    limit 0, 1;