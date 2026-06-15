using System;

namespace OperatorApp.Models
{
    public class Vector2D
    {
        public double X { get; private set; }
        public double Y { get; private set; }

        public Vector2D() : this(0, 0)
        {
        }

        public Vector2D(double x, double y)
        {
            X = x;
            Y = y;
        }

        public double DoDai
        {
            get { return Math.Sqrt(X * X + Y * Y); }
        }

        public static Vector2D operator +(Vector2D a, Vector2D b)
        {
            return new Vector2D(a.X + b.X, a.Y + b.Y);
        }

        public static Vector2D operator -(Vector2D a, Vector2D b)
        {
            return new Vector2D(a.X - b.X, a.Y - b.Y);
        }

        public static Vector2D operator *(Vector2D v, double k)
        {
            return new Vector2D(v.X * k, v.Y * k);
        }

        public static Vector2D operator *(double k, Vector2D v)
        {
            return v * k;
        }

        public static Vector2D operator -(Vector2D v)
        {
            return new Vector2D(-v.X, -v.Y);
        }

        public override string ToString()
        {
            return $"({X:F2}, {Y:F2})";
        }
    }
}