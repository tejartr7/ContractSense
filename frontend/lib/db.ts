import mongoose from "mongoose"

const connectDB = async () => {
  if (mongoose.connections[0].readyState) {
    console.log("🚀 Already connected to database.")
    return true
  }

  if (!process.env.NEXT_PUBLIC_MONGODB_URI) {
    console.error("🔴 NEXT_PUBLIC_MONGODB_URI is not defined.")
    return false
  }
  
  try {
    await mongoose.connect(process.env.NEXT_PUBLIC_MONGODB_URI)
    console.log("🚀 Successfully connected to MongoDB.")
    return true
  } catch (error) {
    console.error("🔴 Failed to connect to MongoDB:", error)
    return false
  }
}

export default connectDB