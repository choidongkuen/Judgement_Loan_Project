package com.example.api.aop

import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Aspect
@Component
class LogAspect {

    var logger = KotlinLogging.logger { }

    @Pointcut("within(com.example.api..*)") // api 모듈 하위에 모든 패키지
    private fun isApi() {}


    @Around("isApi()")
    fun loggingAspect(joinPoint: ProceedingJoinPoint): Any{

        val stopWatch = StopWatch()
        stopWatch.start() // stopWatch 실행

        val result = joinPoint.proceed() // 실행

        stopWatch.stop() // stopWatch 종료

        logger.info {
            "${joinPoint.signature.name} ${joinPoint.args[0]} ${stopWatch.lastTaskTimeMillis}"
        }

        return result

    }
}