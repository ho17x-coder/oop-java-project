using System;
using OperatorApp.Models;

namespace OperatorApp
{
    internal class Program
    {
        static void Main(string[] args)
        {

            Console.OutputEncoding = System.Text.Encoding.UTF8;

            Console.WriteLine("===== BAI 1: VECTOR2D =====");

            Vector2D v1 = new Vector2D(3, 4);
            Vector2D v2 = new Vector2D(1, 2);

            Console.WriteLine($"v1 = {v1}");
            Console.WriteLine($"v2 = {v2}");
            Console.WriteLine($"v1 + v2 = {v1 + v2}");
            Console.WriteLine($"v1 - v2 = {v1 - v2}");
            Console.WriteLine($"v1 * 2 = {v1 * 2}");
            Console.WriteLine($"3 * v2 = {3 * v2}");
            Console.WriteLine($"-v1 = {-v1}");
            Console.WriteLine($"|v1| = {v1.DoDai:F4}");

            Console.WriteLine();
            Console.WriteLine("===== BAI 2: MONEY =====");

            Money luong = new Money(15000000, "VND");
            Money thuong = new Money(3000000, "VND");

            Money lamThemGio = luong * 1.5m;

            Console.WriteLine($"Luong co ban: {luong}");
            Console.WriteLine($"Thuong thang: {thuong}");
            Console.WriteLine($"Luong lam them: {lamThemGio}");
            Console.WriteLine($"Tong thu nhap: {luong + thuong}");
            Console.WriteLine($"Luong > Thuong: {luong > thuong}");

            try
            {
                Money usd = new Money(100, "USD");

                Money tong = luong + usd;
            }
            catch (InvalidOperationException ex)
            {
                Console.WriteLine($"Loi: {ex.Message}");
            }

            Console.ReadKey();
        }
    }
}