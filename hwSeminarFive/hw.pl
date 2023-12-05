
sum([], 0).
sum([FirstElement|OtherElements], Sum) :-
    sum(OtherElements, CurrentSum), Sum is CurrentSum + FirstElement.

?- sum([6,4,7,3,9,1], SumAllElements), write(SumAllElements).

