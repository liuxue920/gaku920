package com.fafamc.redpackage.vo;

import com.fafamc.redpackage.domain.Subpackage;
import lombok.Data;

@Data
public class OpenResult {
    private Package aPackage;
    private Subpackage subpackage;
    private boolean flag;

    public static OpenResult failed(){
        OpenResult result = new OpenResult();
        result.setFlag(false);
        return result;
    }
}
