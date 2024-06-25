package com.example.customannotation.config;

import com.example.customannotation.annotation.ApiOperationCustom;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenApiCustomiser customOpenApiCustomiser(RequestMappingHandlerMapping handlerMapping) {
        return openApi -> {
            Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
            for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
                HandlerMethod handlerMethod = entry.getValue();
                ApiOperationCustom apiOperationCustom = handlerMethod.getMethodAnnotation(ApiOperationCustom.class);
                if (apiOperationCustom != null) {
                    Operation operation = new Operation();
                    operation.setSummary(apiOperationCustom.value());
                    operation.setDescription(apiOperationCustom.notes());

                    ApiResponses apiResponses = new ApiResponses();
                    ApiResponse apiResponse = new ApiResponse().description("Successful Operation");
                    apiResponses.addApiResponse("200", apiResponse);
                    operation.setResponses(apiResponses);

                    // Get the path and method for this handler
                    String path = entry.getKey().getPatternsCondition().getPatterns().iterator().next();
                    PathItem.HttpMethod httpMethod = PathItem.HttpMethod.valueOf(entry.getKey().getMethodsCondition().getMethods().iterator().next().name());

                    openApi.path(path, new PathItem());
                }
            }
        };
    }
}
