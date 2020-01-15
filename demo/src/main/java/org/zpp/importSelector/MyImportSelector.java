package org.zpp.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.zpp.dao.IndexDao2;

public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{ImportSelectorDao.class.getName()};
	}
}
