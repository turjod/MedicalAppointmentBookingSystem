package com.cg.MedicalAppointmentBookingSystem.annotations;
/**
 * Security annotation is used to specify the role of a class in the system.
 * It is not used in the current implementation because we are using java 7.
 * The default role is "User".
 *
 * @author Aiindrila
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Security {
    String role() default "User";
}
