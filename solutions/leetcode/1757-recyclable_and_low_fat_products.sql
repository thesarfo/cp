-- # Write your MySQL query statement below
select product_id from Products
where low_fats = 'Y' and recyclable = 'Y';

-- # diff way
select product_id from Products
where not low_fats = 'N' and recyclable != 'N';