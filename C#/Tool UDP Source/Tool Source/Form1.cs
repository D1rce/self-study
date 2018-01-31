using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace daikinUdp
{
    public partial class Form1 : Form
	{
		public Form1()
		{
			InitializeComponent();

		}

        /// <summary>
        /// 开关：在监听UDP报文阶段为true，否则为false
        /// </summary>
        bool IsUdpcRecvStart = false;
        /// <summary>
        /// 线程：不断监听UDP报文
        /// </summary>
        Thread thrRecv;

        /// <summary>
        /// 用于UDP发送的网络服务类
        /// </summary>
        private UdpClient udpcSend;
        /// <summary>
        /// 用于UDP接收的网络服务类
        /// </summary>
        private UdpClient udpcRecv;

        /// <summary>
        /// 接收数据
        /// </summary>
        /// <param name="obj"></param>
        private void ReceiveMessage(object obj)
        {
            IPEndPoint remoteIpep = new IPEndPoint(IPAddress.Any, 0);
            while (true)
            {
                try
                {
                    byte[] bytRecv = udpcRecv.Receive(ref remoteIpep);
                    string message = Encoding.UTF8.GetString(
                        bytRecv, 0, bytRecv.Length);
                    //string msg = Encoding.UTF8.GetString(client.Receive(ref remoteIpep));
                    //192.168.1.134:35872[[S]2017 - 05 - 11 11:05:21[error] 00804F91168D gateway->app - gateway finds error-0 - 2]
                    ShowMessage(txtlog,
                        string.Format("{0} : {1} ", remoteIpep, message));
                    if (message.StartsWith("[S]"))
                    {
                        LogHelper lh = new LogHelper(DateTime.Now.ToString("yyyyMMdd") + ".log");
                        lh.WriteLog(message);
                    }

                }
                catch (Exception ex)
                {
                    ShowMessage(txtlog, ex.Message);
                    break;
                }
            }
        }

        // 向TextBox中添加文本
        delegate void ShowMessageDelegate(TextBox txtbox, string message);
        private void ShowMessage(TextBox txtbox, string message)
        {
            if (txtbox.InvokeRequired)
            {
                ShowMessageDelegate showMessageDelegate = ShowMessage;
                txtbox.Invoke(showMessageDelegate, new object[] { txtbox, message });
            }
            else
            {
                if (txtbox.Text.Length > 9999)
                {
                    txtbox.Text = "";
                }
                txtbox.Text = message + "\r\n" + txtbox.Text;
            }
        }

        /// <summary>
        /// 关闭程序，强制退出
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            Environment.Exit(0);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            udp_ThreadInit();
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            this.txtIp1.Text = "8002";
            udp_ThreadInit();
        }

        private void InPutNumber(object sender, KeyPressEventArgs e)
        {
            if (!Char.IsNumber(e.KeyChar) && e.KeyChar != (char)8)
            {
                e.Handled = true;
            }
            else
            {

            }
        }

        /// <summary>
        /// 加载线程启动/关闭
        /// </summary>
        private void udp_ThreadInit()
        {
            try
            {
                if (this.txtIp1.Text.Trim() == string.Empty)
                {
                    MessageBox.Show("请先输入端口号");
                    return;
                }

                if (!IsUdpcRecvStart) // 未监听的情况，开始监听
                {
                    IPEndPoint localIpep = new IPEndPoint(
                        IPAddress.Any, Convert.ToInt32(this.txtIp1.Text)); // 本机IP和监听端口号

                    udpcRecv = new UdpClient(localIpep);

                    thrRecv = new Thread(ReceiveMessage);
                    thrRecv.Start();

                    IsUdpcRecvStart = true;
                    ShowMessage(txtlog, "UDP监听器已成功启动");

                    this.txtIp1.Enabled = false;
                }
                else                  // 正在监听的情况，终止监听
                {
                    thrRecv.Abort(); // 必须先关闭这个线程，否则会异常
                    udpcRecv.Close();

                    IsUdpcRecvStart = false;
                    ShowMessage(txtlog, "UDP监听器已成功关闭");
                    this.txtIp1.Enabled = true;
                }
            }
            catch (Exception ex)
            {
                ShowMessage(txtlog, ex.Message);
            }
        }
    }
}
