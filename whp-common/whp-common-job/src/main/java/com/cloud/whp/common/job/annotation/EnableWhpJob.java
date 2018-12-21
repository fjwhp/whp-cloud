package com.cloud.whp.common.job.annotation;

import com.cloud.whp.common.job.ElasticJobAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author whp
 * @date 2018年12月19日
 * 开启whp-cloud job
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ElasticJobAutoConfiguration.class})
public @interface EnableWhpJob {
}
