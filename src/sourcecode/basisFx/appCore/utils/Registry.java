package basisFx.appCore.utils;

import basisFx.appCore.windows.WindowFabric;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.service.ServiceCrossWindow;

import java.util.HashMap;

public class Registry   {
   public static WindowFabric windowFabric;
   public static WindowAbstraction mainWindow;

   public static HashMap<String, ServiceCrossWindow> crossWindowMediators =new HashMap<>();
   public static HashMap<String, Object> crossWindowTransfer =new HashMap<>();


}