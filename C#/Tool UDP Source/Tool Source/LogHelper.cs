using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace daikinUdp
{
	public class LogHelper
	{
		private string LogPath; //= "c://log";  
		private string LogName;// = "/ptzLog.log";  

		public LogHelper(string name)
		{
			LogPath = System.Configuration.ConfigurationSettings.AppSettings["LogPath"];
			LogName = "/" + name;
		}

		public void WriteLog(string strlog)
		{
			try
			{
                //LogPath = @"F:\新建文件夹\Sensor3\obj";

                DirectoryInfo d = Directory.CreateDirectory(LogPath);
				FileStream fs = new FileStream(LogPath + LogName, System.IO.FileMode.Append);
				StreamWriter sw = new StreamWriter(fs, System.Text.Encoding.Default);
				sw.WriteLine(strlog);
				sw.Close();
				fs.Close();
			}
			catch
			{

			}
		}


	}
}
