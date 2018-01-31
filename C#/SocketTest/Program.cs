using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Web.Script.Serialization;

namespace SocketTest
{
      class Program
    {
        private static byte[] result = new byte[1024];
        private static int myProt = 8021;   //端口
        static Socket[] clientSocket = new Socket[500000];
        static int j = 0;

       

        static void Main(string[] args)
        {
            TestNumberous();
        }      

        static void TestNumberous()
        {
            for (int i = 0; i < clientSocket.Count(); i++)
            {
                //设定服务器IP地址
                IPAddress ip = IPAddress.Parse("172.29.140.58");
                //IPAddress ip = IPAddress.Parse("172.29.140.58");

                clientSocket[i] = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                try
                {
                    clientSocket[i].Connect(new IPEndPoint(ip, myProt)); //配置服务器IP与端口
                    Console.WriteLine("connect success,seq=" + (j++).ToString());
                }
                catch
                {
                    Console.WriteLine("开始发送数据...");
                    break;
                }
                Thread.Sleep(5);
            }

            while (true)
            {
                string name = Dns.GetHostName();
                for (int i = 0; i < j; i++)
                {
                    string str = name + "->soc seq:" + i.ToString();
                    Console.WriteLine("send:" + str);
                    clientSocket[i].Send(System.Text.Encoding.Default.GetBytes(str));
                    Thread.Sleep(100);
                }
            }
            Console.ReadLine();
        }
    }
}
