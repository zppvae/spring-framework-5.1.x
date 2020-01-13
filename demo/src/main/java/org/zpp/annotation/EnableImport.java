package org.zpp.annotation;


import org.springframework.context.annotation.Import;
import org.zpp.importSelector.MyImportSelector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class)
public @interface EnableImport {
}
