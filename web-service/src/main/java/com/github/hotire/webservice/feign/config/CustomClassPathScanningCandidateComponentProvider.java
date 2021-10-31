package com.github.hotire.webservice.feign.config;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

public class CustomClassPathScanningCandidateComponentProvider extends ClassPathScanningCandidateComponentProvider {
    /**
     * Feign
     */
    @Override
    protected boolean isCandidateComponent(
            AnnotatedBeanDefinition beanDefinition) {
        boolean isCandidate = false;
        if (beanDefinition.getMetadata().isIndependent()) {
            if (!beanDefinition.getMetadata().isAnnotation()) {
                isCandidate = true;
            }
        }
        return isCandidate;
    }

    /**
     * origin
     */
//    @Override
//    public boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
//        for (TypeFilter tf : this.excludeFilters) {
//            if (tf.match(metadataReader, getMetadataReaderFactory())) {
//                return false;
//            }
//        }
//        for (TypeFilter tf : this.includeFilters) {
//            if (tf.match(metadataReader, getMetadataReaderFactory())) {
//                return isConditionMatch(metadataReader);
//            }
//        }
//        return false;
//    }
}
