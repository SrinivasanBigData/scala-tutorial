
(1 to 9).map(0.1 * _) //transform the value
(1 to 9).filter(_ % 2 == 0) // drops unsatified elements
(1 to 9).reduceLeft(_*_) // applies binary function, going from left to right
// (((1*2)*3)*...) = 362880
(1 to 9).reduceRight(_*_)

(1 to 9).filter(_ % 2 == 0).map(0.1 * _)
// the above is exactly same as
for (i <- (1 to 9) if(i%2==0)) yield 0.1*i

