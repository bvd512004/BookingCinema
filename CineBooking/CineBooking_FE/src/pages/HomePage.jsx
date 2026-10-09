import Header from '../components/layout/Header'
import Footer from '../components/layout/Footer'
import HeroSection from '../components/sections/HeroSection'
import MoviesSection from '../components/sections/MoviesSection'
import QuickBookingSection from '../components/sections/QuickBookingSection'
import PromotionsSection from '../components/sections/PromotionsSection'
import DownloadAppSection from '../components/sections/DownloadAppSection'
import '../styles/home.css'

function HomePage() {
  return (
    <div className="home-page">
      <Header />
      <main className="home-content">
        <HeroSection />
        <MoviesSection />
        <QuickBookingSection />
        <PromotionsSection />
        <DownloadAppSection />
      </main>
      <Footer />
    </div>
  )
}

export default HomePage
