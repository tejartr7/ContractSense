"use client";
import { useState, useEffect } from "react";
import { useSession } from "next-auth/react";
import axios from "axios";

const apiCall = async (userId: string) => {
  try {
    const response = await axios.post(
      "http://localhost:8080/test",
      { id: userId },
      {
        headers: {
          'Content-Type': 'application/json'
        }
      }
    );
    return response;
  } catch (error) {
    if (axios.isAxiosError(error)) {
      console.error('Error status:', error.response?.status);
      console.error('Error data:', error.response?.data);
    }
    throw error;
  }
};

export default function Home() {
  const { data: session, status } = useSession({ required: true });
  const [apiData, setApiData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      if (session?.user?._id) {
        try {
          const data = await apiCall(session.user._id); // Pass user.id
          setApiData(data.data); // Store the response data in state
        } catch (error) {
          console.error("Error fetching data:", error);
        }
      }
    };
    if (session?.user?._id) {
      fetchData();
    }
  }, [session?.user?._id]); // Re-run effect when user.id changes

  if (status === "loading") {
    return <div>Loading...</div>;
  }

  if (!session?.user?._id) {
    return <div>Please sign in to continue.</div>;
  }

  return (
    <div>
      <h1>Welcome to the Home Page</h1>
      <p>{session?.user?.email}</p>
      <p>User ID: {session?.user?._id}</p> {/* Display user ID */}
      {apiData ? (
        <div>
          <h2>API Response:</h2>
          <pre>{JSON.stringify(apiData, null, 2)}</pre>{" "}
          {/* Display the response from backend */}
        </div>
      ) : (
        <p>No data to display yet.</p>
      )}
    </div>
  );
}
