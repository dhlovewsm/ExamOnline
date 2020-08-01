package com.examonline.controller.aop;

public @interface ArchivesLog {

    /**
     * 操作类型
     * @return
     */
    public String operationType() default "";

    /**
     * 操作名称
     * @return
     */
    public String operationName() default "";


}
