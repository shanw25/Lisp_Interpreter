(setq A 29)
(setq B (+ A 13))
B
((lambda () (+ 21 21)))
((lambda (A) (+ A 21)) 21)
((lambda (A B) (+ A B)) 21 21)
(setq listDerivedSafe (
	lambda (Distance Duration Exhalation)
	(cond ((and (>= Distance 13) (<= Duration 30) (<= Exhalation 30)) T)
		((and (>= Distance 6) (<= Duration 30) (<= Exhalation 10)) T)
		((and (>= Distance 27) (<= Duration 30) (<= Exhalation 50)) T)
		((and (>= Distance 13) (<= Duration 15) (<= Exhalation 50)) T)
		((and (>= Distance 13) (<= Duration 120) (<= Exhalation 10)) T)
		((and (>= Distance 27) (<= Duration 120) (<= Exhalation 30)) T)
		((and (>= Distance 6) (<= Duration 15) (<= Exhalation 30)) T)
		)
	))
(setq x 5)
(setq timesGenerator	
     (lambda (x)
  	(function 
                (lambda (y) (* x y))
            )
    )
)
(setq twice (funcall timesGenerator 2))