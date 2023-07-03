Should the rollout code be in function or outside?

(def feature [arg1]
(if (within-rollout? arg2)
	(do actual feature work)
	(do nothing)))


(main  
(feature args))


I think, it should not be within feature, since name is decptive then.

I feel better would be to have at same level at feature, in main

(and (within-rollout? args)
	(feature args))

-----
