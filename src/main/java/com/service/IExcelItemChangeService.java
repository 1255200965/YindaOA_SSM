package com.service;

import java.io.IOException;
import java.util.Map;

public interface IExcelItemChangeService {

	String validateExcelTitle(String fileDir) throws IOException;

	Map<String, Object> insertAndUpdate(String fileDir) throws IOException;
}
