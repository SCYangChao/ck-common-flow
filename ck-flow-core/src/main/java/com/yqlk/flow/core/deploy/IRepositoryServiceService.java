package com.yqlk.flow.core.deploy;

import java.util.zip.ZipInputStream;

public interface IRepositoryServiceService {
    Boolean deployZipInputStream(String name, ZipInputStream zipInputStream);

    Boolean deployStr(String name, String string);
}
