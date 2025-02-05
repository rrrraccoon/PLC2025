--create inpFunc
--inpFunc = [1..5] 
inpFunc a b = [a..b]

--Define applicatorFunc
--applicatorFunc inpFunc a b s = if s=='s' then sum inpFunc(a b) else (sum inpFunc(a b))/(b-a+1)
--rewritten with guards:
applicatorFunc inpFunc a b s | s =='s' = sum inpFunc(a b)
                             | otherwise = (sum (inpuFunc(a b)))/(b-a+1)

main = do
    let result = applicatorFunc inpFunc 1 5 'a' --Call applicatorFunc with inpFunc and 'a' as args
    putStrLn("sum = " ++ show(result))